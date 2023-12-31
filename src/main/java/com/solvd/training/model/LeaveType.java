package com.solvd.training.model;

public class LeaveType {
    private int idLeaveType;
    private String leaveTypeName;

    public LeaveType(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }

    public int getIdLeaveType() {
        return idLeaveType;
    }

    public void setIdLeaveType(int idLeaveType) {
        this.idLeaveType = idLeaveType;
    }

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }

    @Override
    public String toString() {
        return "LeaveType{" +
                "idLeaveType=" + idLeaveType +
                ", leaveTypeName='" + leaveTypeName + '\'' +
                '}';
    }
}
