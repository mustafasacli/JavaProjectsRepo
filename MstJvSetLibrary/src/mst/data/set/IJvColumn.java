/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mst.data.set;

import java.sql.ResultSetMetaData;

/**
 *
 * @author Mustafa SACLI
 */
public interface IJvColumn {

    String getDataTypeClassName();

    int getDisplaySize();

    String getColumnLabel();

    int getDataType();

    boolean isAutoIncrement();

    int isNullable();

    boolean isCaseSensitive();

    int getPrecision();

    int getScale();

    boolean isCurrency();

    boolean isDefinitelyWritable();

    boolean isReadOnly();

    boolean isSearchable();

    boolean isSigned();

    boolean isWritable();

    String getDataTypeName();

    String getColumnName();

    void setColumnName(String columnName);

    int getColumnIndex();

    void setColumnIndex(int columnIndex);

    JvTable jetJvTable();

    void loadDataPropertiesFromJvColumn(JvColumn column);

    void loadDataPropertiesFromRsMetaData(ResultSetMetaData rsmd, int colIndex) throws Exception;
}
