/*
 * Copyright 2003 - 2014 The eFaps Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Revision:        $Rev$
 * Last Changed:    $Date$
 * Last Changed By: $Author$
 */

package org.efaps.jasper.eql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.data.AbstractDataAdapterService;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRDataset;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRValueParameter;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.query.JRQueryExecuter;
import net.sf.jasperreports.util.SecretsProvider;
import net.sf.jasperreports.util.SecretsProviderFactory;

import org.efaps.jasper.data.connection.EFapsConnection;
import org.efaps.json.data.AbstractValue;
import org.efaps.json.data.DataList;
import org.efaps.json.data.ObjectData;

public class EqlQueryExecuter
    implements JRQueryExecuter
{

    /**
     * Connection for this Executer.
     */
    private final EFapsConnection connection;

    /**
     * DataSet to be used.
     */
    private final JRDataset dataset;

    /**
     * Password.
     */
    private String password;

    /**
     * The statement used to fire the query.
     */
    public EqlQueryExecuter(final JasperReportsContext _jContext,
                            final JRDataset _dataset,
                            final Map<String, ? extends JRValueParameter> _parameters)
    {
        this.connection = (EFapsConnection) _parameters.get(JRParameter.REPORT_CONNECTION).getValue();
        this.dataset = _dataset;
        for (final SecretsProviderFactory secFac : _jContext.getExtensions(SecretsProviderFactory.class)) {
            final SecretsProvider provider = secFac.getSecretsProvider(AbstractDataAdapterService.SECRETS_CATEGORY);
            if (provider != null) {
                if (provider.hasSecret(this.connection.getDataAdapter().getPassword())) {
                    this.password = provider.getSecret(this.connection.getDataAdapter().getPassword());
                }
            }
        }
    }

    /**
     * Executes the query and creates a {@link JRDataSource JRDataSource} out of
     * the result.
     *
     * @return a {@link JRDataSource JRDataSource} wrapping the query execution
     *         result.
     * @throws JRException
     */
    @Override
    public JRDataSource createDatasource()
        throws JRException
    {
        final List<Map<String, ?>> list = new ArrayList<>();

        final String stmtStr = this.dataset.getQuery().getText();
        final DataList dataList = this.connection.executeQuery(stmtStr, this.password);
        for (final ObjectData val : dataList) {
            final Map<String, Object> map = new HashMap<>();
            list.add(map);
            for (final AbstractValue<?> value : val.getValues()) {
                if (value != null) {
                    map.put(value.getKey(), value.getValue());
                }
            }
        }
        final JRMapCollectionDataSource ret = new JRMapCollectionDataSource(list);
        return ret;
    }

    /**
     * Closes resources kept open during the data source iteration.
     * <p/>
     * This method is called after the report is filled or the dataset is
     * iterated. If a resource is not needed after the data source has been
     * created, it should be released at the end of {@link #createDatasource()
     * createDatasource}.
     */
    @Override
    public synchronized void close()
    {

    }

    /**
     * Cancels the query if it's currently running.
     * <p/>
     * This method will be called from a different thread if the client decides
     * to cancel the filling process.
     *
     * @return <code>true</code> if and only if the query was running and it has
     *         been canceled
     * @throws JRException on error
     */
    @Override
    public synchronized boolean cancelQuery()
        throws JRException
    {
        return false;
    }
}
