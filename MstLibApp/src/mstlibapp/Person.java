/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mstlibapp;

import java.util.ArrayList;
import mst.data.querybuilding.AbstractBaseBO;

/**
 *
 * @author eww
 */
public class Person extends AbstractBaseBO {

    private int _PersonId;
    private String _FirstName = "";
    private String _LastName = "";
    private double _Salary = 0.0d;

    @Override
    public String getTable() {
        return "Person";
    }

    @Override
    public String getIdColumn() {
        return "PersonId";
    }

    /**
     * @return the _PersonId
     */
    public int getPersonId() {
        return _PersonId;
    }

    /**
     * @param PersonId the _PersonId to set
     */
    public void setPersonId(int PersonId) {
        this._PersonId = PersonId;
        addChangeList("PersonId");
    }

    /**
     * @return the _FirstName
     */
    public String getFirstName() {
        return _FirstName;
    }

    /**
     * @param FirstName the _FirstName to set
     */
    public void setFirstName(String FirstName) {
        this._FirstName = FirstName;
        addChangeList("FirstName");
    }

    /**
     * @return the _LastName
     */
    public String getLastName() {
        return _LastName;
    }

    /**
     * @param LastName the _LastName to set
     */
    public void setLastName(String LastName) {
        this._LastName = LastName;
        addChangeList("LastName");
    }

    /**
     * @return the _Salary
     */
    public double getSalary() {
        return _Salary;
    }

    /**
     * @param Salary the _Salary to set
     */
    public void setSalary(double Salary) {
        this._Salary = Salary;
        addChangeList("Salary");
    }
}
