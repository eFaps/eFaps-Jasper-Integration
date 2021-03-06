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
package org.efaps.jasper.data;

import java.util.Map;

import net.sf.jasperreports.data.AbstractDataAdapterService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperReportsContext;

import org.efaps.jasper.data.connection.EFapsConnection;


/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id$
 */
public class EFapsDataAdapterService
    extends AbstractDataAdapterService
{

    private final EFapsDataAdapter dataAdapter;

    private EFapsConnection connection;

    public EFapsDataAdapterService(final JasperReportsContext _jContext,
                                   final EFapsDataAdapter _dataAdapter)
    {
        super(_jContext, _dataAdapter);
        this.dataAdapter = _dataAdapter;
    }

    @Override
    public void contributeParameters(final Map<String, Object> _parameters)
        throws JRException
    {
        if (this.dataAdapter != null) {
            this.connection = new EFapsConnection(this.dataAdapter);
            _parameters.put(JRParameter.REPORT_CONNECTION, this.connection);
        }
    }
}
