/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Weichuan
 */
public class Job {
    private String id; 
    private String title;
    private String description;
    private String requirement;
    private String cName;
    private String cType;
    private String cIndustry;
    private String website;
    private String lcoation;
    private String cDescription;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the requirement
     */
    public String getRequirement() {
        return requirement;
    }

    /**
     * @param requirement the requirement to set
     */
    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    /**
     * @return the cName
     */
    public String getcName() {
        return cName;
    }

    /**
     * @param cName the cName to set
     */
    public void setcName(String cName) {
        this.cName = cName;
    }

    /**
     * @return the cType
     */
    public String getcType() {
        return cType;
    }

    /**
     * @param cType the cType to set
     */
    public void setcType(String cType) {
        this.cType = cType;
    }

    /**
     * @return the cIndustry
     */
    public String getcIndustry() {
        return cIndustry;
    }

    /**
     * @param cIndustry the cIndustry to set
     */
    public void setcIndustry(String cIndustry) {
        this.cIndustry = cIndustry;
    }

    /**
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website the website to set
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return the lcoation
     */
    public String getLcoation() {
        return lcoation;
    }

    /**
     * @param lcoation the lcoation to set
     */
    public void setLcoation(String lcoation) {
        this.lcoation = lcoation;
    }

    /**
     * @return the cDescription
     */
    public String getcDescription() {
        return cDescription;
    }

    /**
     * @param cDescription the cDescription to set
     */
    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }
    
}
