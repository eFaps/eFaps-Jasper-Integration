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

package org.efaps.jasper.data.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.efaps.jasper.data.EFapsDataAdapter;
import org.efaps.jasper.data.EFapsDataAdapterImpl;
import org.efaps.json.data.DataList;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 *
 * @author Eric Diaz
 *
 */
public class EFapsConnection
    implements Connection
{


    private final EFapsDataAdapter dataAdapter;

    public EFapsConnection(final EFapsDataAdapter _dataAdapter)
    {
        this.dataAdapter = _dataAdapter;
    }

    @Override
    public void close()
    {

    }

    @Override
    public boolean isClosed()
        throws SQLException
    {
        return true;
    }

    @Override
    public <T> T unwrap(final Class<T> iface)
        throws SQLException
    {
        return null;
    }

    @Override
    public boolean isWrapperFor(final Class<?> iface)
        throws SQLException
    {
        return false;
    }

    @Override
    public Statement createStatement()
        throws SQLException
    {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(final String sql)
        throws SQLException
    {
        return null;
    }

    @Override
    public CallableStatement prepareCall(final String sql)
        throws SQLException
    {
        return null;
    }

    @Override
    public String nativeSQL(final String sql)
        throws SQLException
    {
        return null;
    }

    @Override
    public void setAutoCommit(final boolean autoCommit)
        throws SQLException
    {
    }

    @Override
    public boolean getAutoCommit()
        throws SQLException
    {
        return false;
    }

    @Override
    public void commit()
        throws SQLException
    {
    }

    @Override
    public void rollback()
        throws SQLException
    {
    }

    @Override
    public DatabaseMetaData getMetaData()
        throws SQLException
    {
        return null;
    }

    @Override
    public void setReadOnly(final boolean readOnly)
        throws SQLException
    {
    }

    @Override
    public boolean isReadOnly()
        throws SQLException
    {
        return false;
    }

    @Override
    public void setCatalog(final String catalog)
        throws SQLException
    {
    }

    @Override
    public String getCatalog()
        throws SQLException
    {
        return null;
    }

    @Override
    public void setTransactionIsolation(final int level)
        throws SQLException
    {
    }

    @Override
    public int getTransactionIsolation()
        throws SQLException
    {
        return 0;
    }

    @Override
    public SQLWarning getWarnings()
        throws SQLException
    {
        return null;
    }

    @Override
    public void clearWarnings()
        throws SQLException
    {
    }

    @Override
    public Statement createStatement(final int resultSetType,
                                     final int resultSetConcurrency)
        throws SQLException
    {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(final String sql,
                                              final int resultSetType,
                                              final int resultSetConcurrency)
        throws SQLException
    {
        return null;
    }

    @Override
    public CallableStatement prepareCall(final String sql,
                                         final int resultSetType,
                                         final int resultSetConcurrency)
        throws SQLException
    {
        return null;
    }

    @Override
    public Map<String, Class<?>> getTypeMap()
        throws SQLException
    {
        return null;
    }

    @Override
    public void setTypeMap(final Map<String, Class<?>> map)
        throws SQLException
    {
    }

    @Override
    public void setHoldability(final int holdability)
        throws SQLException
    {
    }

    @Override
    public int getHoldability()
        throws SQLException
    {
        return 0;
    }

    @Override
    public Savepoint setSavepoint()
        throws SQLException
    {
        return null;
    }

    @Override
    public Savepoint setSavepoint(final String name)
        throws SQLException
    {
        return null;
    }

    @Override
    public void rollback(final Savepoint savepoint)
        throws SQLException
    {
    }

    @Override
    public void releaseSavepoint(final Savepoint savepoint)
        throws SQLException
    {
    }

    @Override
    public Statement createStatement(final int resultSetType,
                                     final int resultSetConcurrency,
                                     final int resultSetHoldability)
        throws SQLException
    {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(final String sql,
                                              final int resultSetType,
                                              final int resultSetConcurrency,
                                              final int resultSetHoldability)
        throws SQLException
    {
        return null;
    }

    @Override
    public CallableStatement prepareCall(final String sql,
                                         final int resultSetType,
                                         final int resultSetConcurrency,
                                         final int resultSetHoldability)
        throws SQLException
    {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(final String sql,
                                              final int autoGeneratedKeys)
        throws SQLException
    {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(final String sql,
                                              final int[] columnIndexes)
        throws SQLException
    {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(final String sql,
                                              final String[] columnNames)
        throws SQLException
    {
        return null;
    }

    @Override
    public Clob createClob()
        throws SQLException
    {
        return null;
    }

    @Override
    public Blob createBlob()
        throws SQLException
    {
        return null;
    }

    @Override
    public NClob createNClob()
        throws SQLException
    {
        return null;
    }

    @Override
    public SQLXML createSQLXML()
        throws SQLException
    {
        return null;
    }

    @Override
    public boolean isValid(final int timeout)
        throws SQLException
    {
        return false;
    }

    @Override
    public void setClientInfo(final String name,
                              final String value)
        throws SQLClientInfoException
    {
    }

    @Override
    public void setClientInfo(final Properties properties)
        throws SQLClientInfoException
    {
    }

    @Override
    public String getClientInfo(final String name)
        throws SQLException
    {
        return null;
    }

    @Override
    public Properties getClientInfo()
        throws SQLException
    {
        return null;
    }

    @Override
    public Array createArrayOf(final String typeName,
                               final Object[] elements)
        throws SQLException
    {
        return null;
    }

    @Override
    public Struct createStruct(final String typeName,
                               final Object[] attributes)
        throws SQLException
    {
        return null;
    }

    @Override
    public void abort(final Executor arg0)
        throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public int getNetworkTimeout()
        throws SQLException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getSchema()
        throws SQLException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setNetworkTimeout(final Executor arg0,
                                  final int arg1)
        throws SQLException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setSchema(final String arg0)
        throws SQLException
    {
        // TODO Auto-generated method stub

    }

    public DataList executeQuery(final String _stmtStr,
                                 final String _password)
    {
        DataList ret = null;
        try {
            final HttpClientBuilder httpClient = HttpClientBuilder.create();
            final HttpPost postRequest = new HttpPost(this.dataAdapter.getUrl() + "/eql/query");
            final NameValuePair paier = new BasicNameValuePair("stmt", _stmtStr);

            final List<NameValuePair> postParams = new ArrayList<>();
            postParams.add(paier);
            postRequest.setEntity(new UrlEncodedFormEntity(postParams));
            postRequest.addHeader("accept", "application/json");
            final UsernamePasswordCredentials creds = new UsernamePasswordCredentials(
                            this.dataAdapter.getUserName(), _password);
            final CredentialsProvider credsProvider = new BasicCredentialsProvider();
            credsProvider.setCredentials(new AuthScope(null, AuthScope.ANY_PORT), creds);
            final HttpClientContext context = HttpClientContext.create();
            context.setCredentialsProvider(credsProvider);

            final HttpResponse response = httpClient.build().execute(postRequest,
                            context);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                                + response.getStatusLine().getStatusCode());
            }

            final BufferedReader br = new BufferedReader(new InputStreamReader(
                            response.getEntity().getContent()));

            final ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                            false);
            mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
            mapper.registerModule(new JodaModule());

            ret = mapper.readValue(br, DataList.class);
            System.out.println(ret);

        } catch (final ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }

    public static void main(final String... op)
    {
        final EFapsDataAdapter dat = new EFapsDataAdapterImpl();
        dat.setUserName("Administrator");
        final EFapsConnection von = new EFapsConnection(dat);
        von.executeQuery("asda", "Administrator");
    }


    /**
     * Getter method for the instance variable {@link #dataAdapter}.
     *
     * @return value of instance variable {@link #dataAdapter}
     */
    public EFapsDataAdapter getDataAdapter()
    {
        return this.dataAdapter;
    }
}
