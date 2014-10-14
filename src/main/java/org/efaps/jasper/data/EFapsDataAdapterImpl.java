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

import net.sf.jasperreports.data.AbstractDataAdapter;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id$
 */
public class EFapsDataAdapterImpl
    extends AbstractDataAdapter
    implements EFapsDataAdapter
{

    private String userName = "User";

    private String password = "Password";

    private String url;

    @Override
    public void setUserName(final String userName)
    {
        this.userName = userName;
    }

    @Override
    public String getUserName()
    {
        return this.userName;
    }

    /**
     * Getter method for the instance variable {@link #password}.
     *
     * @return value of instance variable {@link #password}
     */
    @Override
    public String getPassword()
    {
        return this.password;
    }

    /**
     * Setter method for instance variable {@link #password}.
     *
     * @param _password value for instance variable {@link #password}
     */
    @Override
    public void setPassword(final String _password)
    {
        this.password = _password;
    }

    /**
     * Getter method for the instance variable {@link #url}.
     *
     * @return value of instance variable {@link #url}
     */
    @Override
    public String getUrl()
    {
        return this.url;
    }

    /**
     * Setter method for instance variable {@link #url}.
     *
     * @param _url value for instance variable {@link #url}
     */
    @Override
    public void setUrl(final String _url)
    {
        this.url = _url;
    }
}
