/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mst.data.set;

import java.sql.ResultSet;

/**
 *
 * @author Mustafa SACLI
 */
public final class JvSet implements IJvSet {

    private JvTableCollection _tables = new JvTableCollection();

    public JvSet() {
    }

    public JvSet(ResultSet resultSet) throws Exception {
        _tables.add(new JvTable(resultSet));
    }

    public JvSet(JvTable... tables) {
        if (tables != null) {
            for (JvTable table : tables) {
                if (table != null) {
                    _tables.add(table);
                } else {
                    throw new IllegalArgumentException("JvTable object can not be null.");
                }
            }
        }
    }

    @Override
    public void addResultSet(ResultSet resultSet) throws Exception {
        _tables.add(new JvTable(resultSet));
    }
}
