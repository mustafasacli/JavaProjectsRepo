package mst.data.set;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Mustafa SACLI
 *
 * @since 1.7
 */
public final class JvRow implements IJvRow {

    private JvCellCollection _cellCollection = new JvCellCollection();
    private JvColumnCollection _columnCollection = new JvColumnCollection();
    private JvTable _table = null;
    private int _rowIndex = -1;

    public JvRow(int rowIndex, JvColumnCollection columnCollection) {
        _rowIndex = rowIndex;
        _columnCollection = columnCollection;
        _cellCollection = new JvCellCollection(_columnCollection.size());
    }

    @Override
    public JvColumnCollection getJvColumns() {
        return _columnCollection;
    }

    @Override
    public JvTable getJvTable() {
        return _table;
    }

    @Override
    public int getJvRowIndex() {
        return _rowIndex;
    }

    @Override
    public void setJvRowIndex(int rowIndex) {
        _rowIndex = rowIndex;
    }

    @Override
    public JvCell getJvCell(int columnIndex) {
        return _cellCollection.get(columnIndex);
    }

    /**
     * @param column
     * @return JvCell object.
     */
    @Override
    public JvCell getJvCell(JvColumn column) {
        return getJvCell(column.getColumnName());
    }

    @Override
    public JvCell getJvCell(String columnName) {
        JvCell cell = null;
        for (Iterator it = _cellCollection.asIterator(); it.hasNext();) {
            JvCell _cell = (JvCell) it.next();
            if (_cell.getCellName().matches(columnName)) {
                cell = _cell;
                break;
            }
        }

        return cell;
    }

    @Override
    public JvCell[] cellsToArray() {
        JvCell[] cells = new JvCell[_cellCollection.size()];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = _cellCollection.get(i);
        }
        return cells;
    }

    @Override
    public Object[] cellsValuesToArray() {
        ArrayList<Object> objs = new ArrayList<>();
        for (Iterator it = _cellCollection.asIterator(); it.hasNext();) {
            JvCell cell = (JvCell) it.next();
            objs.add(cell.getValue());
        }
        return objs.toArray();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JvRow) {
            JvRow row = (JvRow) obj;
            return _rowIndex == row.getJvRowIndex();
        } else {
            return false;
        }
    }
}
