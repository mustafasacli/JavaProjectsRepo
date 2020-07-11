/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mst.data.set;

import java.sql.ResultSet;

/**
 * @author Mustafa SACLI
 *
 * @since 1.7
 */
public interface IJvTable {

    String getTableName();

    JvRowCollection getRowCollection();

    JvColumnCollection getColumnCollection();

    int getColumnCount();

    int getRowCount();

    JvRow getRow(int rowIndex);

    void load(ResultSet resultSet) throws Exception;

    JvTable selectSomeColumns(int... colIndexes) throws Exception;

    JvTable filterCoumn(int columnIndex, Object... filterVals) throws Exception;

    JvTable filterCoumn(JvColumn column, Object... filterVals) throws Exception;

   // int[] Update(DbConnection dbConn) throws Throwable;
}
