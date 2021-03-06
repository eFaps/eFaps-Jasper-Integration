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

import java.util.Map;

import net.sf.jasperreports.engine.JRDataset;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRValueParameter;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.query.JRQueryExecuter;
import net.sf.jasperreports.engine.query.QueryExecuterFactory;

public class EqlQueryExecuterFactory
    implements QueryExecuterFactory
{

    /**
     * Query language.
     */
    public static final String QUERY_LANGUAGE_EQL = "eFaps";

    @Override
    public JRQueryExecuter createQueryExecuter(final JRDataset dataset,
                                               final Map<String, ? extends JRValueParameter> parameters)
        throws JRException
    {
        return null;
    }

    @Override
    public Object[] getBuiltinParameters()
    {
        return null;
    }

    @Override
    public boolean supportsQueryParameterType(final String className)
    {
        return false;
    }

    @Override
    public JRQueryExecuter createQueryExecuter(final JasperReportsContext _jasperReportsContext,
                                               final JRDataset _dataset,
                                               final Map<String, ? extends JRValueParameter> _parameters)
        throws JRException
    {
        return new EqlQueryExecuter(_jasperReportsContext, _dataset, _parameters);
    }
}
