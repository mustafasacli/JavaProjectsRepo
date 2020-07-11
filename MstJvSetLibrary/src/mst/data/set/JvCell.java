package mst.data.set;

/**
 *
 * @author Mustafa SACLI
 */
public final class JvCell implements IJvCell {

    private Object _value = null;
    private JvRow _row = null;
    private int _cellIndex = -1;
    private String _cellName = "";

    public JvCell(JvRow row) {
        this(row, -1, "", null);
    }

    public JvCell(JvRow row, int cellIndex, String cellName, Object cellValue) {
        _row = row;
        _cellIndex = cellIndex;
        _cellName = cellName;
        _value = cellValue;
    }

    @Override
    public Object getValue() {
        return _value;
    }

    @Override
    public void setValue(Object value) {
        _value = value;
    }

    @Override
    public JvRow getJvRow() {
        return _row;
    }

    @Override
    public int getCellIndex() {
        return _cellIndex;
    }

    @Override
    public JvColumn getJvColumn() {
        return new JvColumn(_cellName, _cellIndex, getJvRow().getJvTable());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JvCell) {
            JvCell cell = (JvCell) obj;
            return _cellName.matches(cell.getCellName());
        } else {
            return false;
        }
    }

    @Override
    public void setCellIndex(int cellIndex) {
        _cellIndex = cellIndex;
    }

    @Override
    public String getCellName() {
        return _cellName;
    }

    @Override
    public void setCellName(String cellName) {
        _cellName = cellName;
    }
}
