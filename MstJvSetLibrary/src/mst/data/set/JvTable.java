package mst.data.set;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mustafa SACLI
 *
 * @since 1.7
 */
public final class JvTable implements IJvTable {

    private String _tableName = "";
    private JvRowCollection _rowCollection = null;
    private JvColumnCollection _columnCollection = null;

    public JvTable(ResultSet resultSet) throws Exception {
        load(resultSet);
    }

    public JvTable() {
        this("", new JvColumnCollection(), new JvRowCollection());
    }

    public JvTable(String tableName) {
        this(tableName, new JvColumnCollection(), new JvRowCollection());
    }

    public JvTable(String tableName, JvColumnCollection Columns, JvRowCollection Rows) {
        _tableName = tableName;
        _rowCollection = Rows;
        _columnCollection = Columns;
    }

    @Override
    public String getTableName() {
        return _tableName;
    }

    @Override
    public JvRowCollection getRowCollection() {
        return _rowCollection;
    }

    @Override
    public JvColumnCollection getColumnCollection() {
        return _columnCollection;
    }

    @Override
    public int getColumnCount() {
        return _columnCollection != null ? _columnCollection.size() : 0;
    }

    @Override
    public int getRowCount() {
        return _rowCollection != null ? _rowCollection.size() : 0;
    }

    @Override
    public JvRow getRow(int rowIndex) {
        return _rowCollection.get(rowIndex);
    }

    @Override
    public JvTable selectSomeColumns(int... colIndexes) throws Exception {
        if (colIndexes == null) {
            throw new Exception("colIndexes array can not be null.");
        } else {
            JvTable jvtable = new JvTable(_tableName, new JvColumnCollection(), new JvRowCollection());
            int colIndex = 1;
            for (int i : colIndexes) {
                JvColumn oldCol = _columnCollection.get(i);
                JvColumn col = new JvColumn(oldCol.getColumnName(), colIndex++, jvtable);
                col.loadDataPropertiesFromJvColumn(oldCol);
                jvtable.getColumnCollection().add(col);
            }
            int rows = _rowCollection.size();
            int cols = jvtable.getColumnCount();
            for (int i = 0; i < rows; i++) {
                JvRow jvrow = _rowCollection.get(i);
                JvRow rw = new JvRow(i, jvtable.getColumnCollection());

                for (int j = 1; j <= cols; j++) {
                    JvColumn jvcol = jvtable.getColumnCollection().get(j);
                    Object val = jvrow.getJvCell(jvcol.getColumnName()).getValue();
                    rw.getJvCell(jvcol.getColumnName()).setValue(val);
                }

            }

            return jvtable;
        }
    }

    @Override
    public JvTable filterCoumn(int columnIndex, Object... filterVals) throws Exception {
        if (getColumnCollection().isValidIndex(columnIndex)) {
            if (filterVals == null) {
                throw new Exception("filterVals array can not be null");
            } else {
                JvColumn col = getColumnCollection().get(columnIndex);
                JvTable jvtable = new JvTable(this.getTableName(), this.getColumnCollection(), new JvRowCollection());
                int rows = this.getRowCollection().size();

                for (int i = 0; i < rows; i++) {

                    JvRow row = this.getRowCollection().get(i);
                    Object val = row.getJvCell(col).getValue();

                    for (Object object : filterVals) {

                        if (val.equals(object)) {
                            jvtable.getRowCollection().add(row);
                            break;
                        }
                    }
                }

                return jvtable;
            }
        } else {
            throw new IndexOutOfBoundsException("Index must be greater than -1 and less than size()");
        }
    }

    @Override
    public JvTable filterCoumn(JvColumn column, Object... filterVals) throws Exception {
        if (getColumnCollection().contains(column)) {
            if (filterVals == null) {
                throw new Exception("filterVals array can not be null");
            } else {
                List<Object> objs = Arrays.asList(filterVals);
                JvTable jvtable = new JvTable(this.getTableName(), this.getColumnCollection(), new JvRowCollection());
                int rows = this.getRowCollection().size();
                for (int i = 0; i < rows; i++) {
                    JvRow row = this.getRowCollection().get(i);
                    Object val = row.getJvCell(column).getValue();
                    if (objs.indexOf(val) != -1) {
                        jvtable.getRowCollection().add(row);
                    }
                }

                return jvtable;
            }
        } else {
            throw new IndexOutOfBoundsException("Invalid Column, ColumnCollection does not contain this column.");
        }
    }

    @Override
    public void load(ResultSet resultSet) throws Exception {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int cols = rsmd.getColumnCount();
        _columnCollection = new JvColumnCollection(cols);
        _tableName = resultSet.getMetaData().getTableName(0);
        _rowCollection = new JvRowCollection();

        for (int i = 1; i <= cols; i++) {
            JvColumn jvcol = new JvColumn(rsmd.getColumnName(i), i, this);
            jvcol.loadDataPropertiesFromRsMetaData(rsmd, i);
            _columnCollection.add(jvcol);
        }

        int rowIndex = 0;
        if (resultSet.first()) {
            do {
                JvRow row = new JvRow(rowIndex++, _columnCollection);
                for (int i = 1; i <= cols; i++) {
                    row.getJvCell(i).setValue(resultSet.getObject(i));
                }
                _rowCollection.add(row);
            } while (resultSet.next());
            resultSet.close();
        } else {
            return;
        }
    }

    public static JvTable loadFromResultSet(ResultSet resultSet) throws Exception {
        JvTable table = new JvTable();
        table.load(resultSet);
        return table;
    }
    /*
     @Override
     public int[] Update(DbConnection dbConn) throws Throwable {
     throw new UnsupportedOperationException("Not supported yet.");
     }
     */
}
