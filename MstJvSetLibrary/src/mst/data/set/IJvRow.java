package mst.data.set;


/**
 *
 * @author Mustafa SACLI
 */

public interface IJvRow {
   
    JvColumnCollection  getJvColumns();
    
   
    JvTable getJvTable();
    
   int getJvRowIndex();
   void setJvRowIndex(int rowIndex);
   
   JvCell getJvCell(int columnIndex);
   JvCell getJvCell(JvColumn column);
   JvCell getJvCell(String columnName);
   
   JvCell[] cellsToArray();
   Object[] cellsValuesToArray();
}
