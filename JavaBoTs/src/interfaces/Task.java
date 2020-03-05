/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.Serializable;


/**
 *
 * @author sdist
 */
public class Task implements Serializable{
    private String taskId;
    private String requirementId;
    private long length;
    private String output;

    public Task(String taskId, String requirementId, long length) {
        this.taskId = taskId;
        this.requirementId = requirementId;
        this.length = length;
        this.output = "Output deseado";
    }

    public String getRequirementId() {
        return requirementId;
    }

    public long getLength() {
        return length;
    }

    public String getOutput() {
        return output;
    }
}