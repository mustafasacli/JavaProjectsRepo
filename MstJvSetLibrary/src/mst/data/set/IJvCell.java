/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mst.data.set;

/**
 *
 * @author eww
 */
public interface IJvCell {

    Object getValue();

    void setValue(Object value);

    JvRow getJvRow();

    int getCellIndex();

    void setCellIndex(int cellIndex);

    String getCellName();

    void setCellName(String cellName);

    JvColumn getJvColumn();
}
