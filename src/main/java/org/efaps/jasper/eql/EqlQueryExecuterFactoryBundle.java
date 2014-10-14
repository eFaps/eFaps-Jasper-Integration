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

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.query.JRQueryExecuterFactoryBundle;
import net.sf.jasperreports.engine.query.QueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRSingletonCache;

public class EqlQueryExecuterFactoryBundle
    implements JRQueryExecuterFactoryBundle
{

    private static final JRSingletonCache<QueryExecuterFactory> cache = new JRSingletonCache<QueryExecuterFactory>(
                    QueryExecuterFactory.class);

    private static final EqlQueryExecuterFactoryBundle INSTANCE = new EqlQueryExecuterFactoryBundle();

    private EqlQueryExecuterFactoryBundle()
    {
    }

    /**
     *
     */
    public static EqlQueryExecuterFactoryBundle getInstance()
    {
        return INSTANCE;
    }

    @Override
    public String[] getLanguages()
    {
        return new String[] { EqlQueryExecuterFactory.QUERY_LANGUAGE_EQL };
    }

    @Override
    public QueryExecuterFactory getQueryExecuterFactory(final String language)
        throws JRException
    {
        QueryExecuterFactory ret = null;
        if (language.equalsIgnoreCase(EqlQueryExecuterFactory.QUERY_LANGUAGE_EQL)) {
            ret =  cache.getCachedInstance(EqlQueryExecuterFactory.class.getName());
        }
        return ret;
    }

}
