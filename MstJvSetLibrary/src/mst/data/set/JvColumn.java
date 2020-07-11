/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mst.data.set;

import java.sql.ResultSetMetaData;

/**
 *
 * @author Mustafa SACLI
 *
 * @since 1.7
 */
public final class JvColumn implements IJvColumn {

    /**
     * Column Data Properties
     */
    private String _dataTypeClassName = "";
    private int _displaySize = 0;
    private String _columnLabel = "";
    private int _dataType = -1;
    private String _dataTypeName = "";
    private boolean _isAutoIncerement = false;
    private int _isNullable = 0;
    boolean _isCaseSensitive;
    int _precision = 0;
    int _scale = 0;
    boolean _isCurrency;
    boolean _isDefinitelyWritable = true;
    boolean _isReadOnly = false;
    boolean _isSearchable = true;
    boolean _isSigned = false;
    boolean _isWritable = true;
    /**
     * Column Properties
     */
    private String _columnName = "";
    private int _columnIndex = -1;
    private JvTable _table = null;

    public JvColumn(JvTable table) {
        _table = table;
    }

    public JvColumn(String columnName, int columnIndex) {
        this(columnName, columnIndex, null);
    }

    public JvColumn(String columnName, int columnIndex, JvTable table) {
        _columnName = columnName;
        _columnIndex = columnIndex;
        _table = table;
    }

    @Override
    public String getColumnName() {
        return _columnName;
    }

    @Override
    public void setColumnName(String columnName) {
        _columnName = columnName;
    }

    @Override
    public int getColumnIndex() {
        return _columnIndex;
    }

    @Override
    public void setColumnIndex(int columnIndex) {
        _columnIndex = columnIndex;
    }

    @Override
    public JvTable jetJvTable() {
        return _table;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JvColumn) {
            JvColumn col = (JvColumn) obj;
            return _columnName.matches(col.getColumnName());
        } else {
            return false;
        }
    }

    @Override
    public String getDataTypeClassName() {
        return _dataTypeClassName;
    }

    @Override
    public int getDisplaySize() {
        return _displaySize;
    }

    @Override
    public String getColumnLabel() {
        return _columnLabel;
    }

    @Override
    public int getDataType() {
        return _dataType;
    }

    @Override
    public String getDataTypeName() {
        return _dataTypeName;
    }

    @Override
    public boolean isAutoIncrement() {
        return _isAutoIncerement;
    }

    @Override
    public int isNullable() {
        return _isNullable;
    }

    @Override
    public boolean isCaseSensitive() {
        return _isCaseSensitive;
    }

    @Override
    public int getPrecision() {
        return _precision;
    }

    @Override
    public int getScale() {
        return _scale;
    }

    @Override
    public boolean isCurrency() {
        return _isCurrency;
    }

    @Override
    public boolean isDefinitelyWritable() {
        return _isDefinitelyWritable;
    }

    @Override
    public boolean isReadOnly() {
        return _isReadOnly;
    }

    @Override
    public boolean isSearchable() {
        return _isSearchable;
    }

    @Override
    public boolean isSigned() {
        return _isSigned;
    }

    @Override
    public boolean isWritable() {
        return _isWritable;
    }

    @Override
    public void loadDataPropertiesFromJvColumn(JvColumn column) {
        _dataTypeClassName = column.getDataTypeClassName();
        _displaySize = column.getDisplaySize();
        _columnLabel = column.getColumnLabel();
        _dataType = column.getDataType();
        _dataTypeName = column.getDataTypeName();
        _isAutoIncerement = column.isAutoIncrement();
        _isNullable = column.isNullable();
        _precision = column.getPrecision();
        _scale = column.getScale();
        _isCaseSensitive = column.isCaseSensitive();
        _isCurrency = column.isCurrency();
        _isDefinitelyWritable = column.isDefinitelyWritable();
        _isReadOnly = column.isReadOnly();
        _isSearchable = column.isSearchable();
        _isSigned = column.isSigned();
        _isWritable = column.isWritable();
    }

    @Override
    public void loadDataPropertiesFromRsMetaData(ResultSetMetaData rsmd, int colIndex) throws Exception {
        _dataTypeClassName = rsmd.getColumnClassName(colIndex);
        _displaySize = rsmd.getColumnDisplaySize(colIndex);
        _columnLabel = rsmd.getColumnLabel(colIndex);
        _dataType = rsmd.getColumnType(colIndex);
        _dataTypeName = rsmd.getColumnTypeName(colIndex);
        _isAutoIncerement = rsmd.isAutoIncrement(colIndex);
        _isNullable = rsmd.isNullable(colIndex);
        _precision = rsmd.getPrecision(colIndex);
        _scale = rsmd.getScale(colIndex);
        _isCaseSensitive = rsmd.isCaseSensitive(colIndex);
        _isCurrency = rsmd.isCurrency(colIndex);
        _isDefinitelyWritable = rsmd.isDefinitelyWritable(colIndex);
        _isReadOnly = rsmd.isReadOnly(colIndex);
        _isSearchable = rsmd.isSearchable(colIndex);
        _isSigned = rsmd.isSigned(colIndex);
        _isWritable = rsmd.isWritable(colIndex);
    }
}
