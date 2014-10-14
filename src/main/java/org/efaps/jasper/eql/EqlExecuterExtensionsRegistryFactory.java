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

import net.sf.jasperreports.engine.JRPropertiesMap;
import net.sf.jasperreports.engine.query.JRQueryExecuterFactoryBundle;
import net.sf.jasperreports.extensions.ExtensionsRegistry;
import net.sf.jasperreports.extensions.ExtensionsRegistryFactory;
import net.sf.jasperreports.extensions.SingletonExtensionRegistry;

public class EqlExecuterExtensionsRegistryFactory
    implements ExtensionsRegistryFactory
{

    private static final ExtensionsRegistry defaultExtensionsRegistry = new SingletonExtensionRegistry<JRQueryExecuterFactoryBundle>(
                    JRQueryExecuterFactoryBundle.class,
                    EqlQueryExecuterFactoryBundle.getInstance());

    @Override
    public ExtensionsRegistry createRegistry(final String _registryId,
                                             final JRPropertiesMap _properties)
    {
        return defaultExtensionsRegistry;
    }
}
