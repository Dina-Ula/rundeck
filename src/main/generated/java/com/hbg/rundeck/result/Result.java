//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.19 at 12:20:01 PM BST 
//


package com.hbg.rundeck.result;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="succeeded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="job" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="group" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="project" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="permalink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="failed">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="job" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="group" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="project" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="permalink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="skipped">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="job" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="group" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="project" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="permalink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="success" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="apiversion" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "succeeded",
    "failed",
    "skipped"
})
@XmlRootElement(name = "result")
public class Result {

    @XmlElement(required = true)
    protected Result.Succeeded succeeded;
    @XmlElement(required = true)
    protected Result.Failed failed;
    @XmlElement(required = true)
    protected Result.Skipped skipped;
    @XmlAttribute(name = "success")
    protected String success;
    @XmlAttribute(name = "apiversion")
    protected Byte apiversion;

    /**
     * Gets the value of the succeeded property.
     * 
     * @return
     *     possible object is
     *     {@link Result.Succeeded }
     *     
     */
    public Result.Succeeded getSucceeded() {
        return succeeded;
    }

    /**
     * Sets the value of the succeeded property.
     * 
     * @param value
     *     allowed object is
     *     {@link Result.Succeeded }
     *     
     */
    public void setSucceeded(Result.Succeeded value) {
        this.succeeded = value;
    }

    /**
     * Gets the value of the failed property.
     * 
     * @return
     *     possible object is
     *     {@link Result.Failed }
     *     
     */
    public Result.Failed getFailed() {
        return failed;
    }

    /**
     * Sets the value of the failed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Result.Failed }
     *     
     */
    public void setFailed(Result.Failed value) {
        this.failed = value;
    }

    /**
     * Gets the value of the skipped property.
     * 
     * @return
     *     possible object is
     *     {@link Result.Skipped }
     *     
     */
    public Result.Skipped getSkipped() {
        return skipped;
    }

    /**
     * Sets the value of the skipped property.
     * 
     * @param value
     *     allowed object is
     *     {@link Result.Skipped }
     *     
     */
    public void setSkipped(Result.Skipped value) {
        this.skipped = value;
    }

    /**
     * Gets the value of the success property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuccess() {
        return success;
    }

    /**
     * Sets the value of the success property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuccess(String value) {
        this.success = value;
    }

    /**
     * Gets the value of the apiversion property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getApiversion() {
        return apiversion;
    }

    /**
     * Sets the value of the apiversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setApiversion(Byte value) {
        this.apiversion = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="job" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="group" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="project" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="permalink" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "job"
    })
    public static class Failed {

        protected List<Result.Failed.Job> job;
        @XmlAttribute(name = "count")
        protected Byte count;

        /**
         * Gets the value of the job property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the job property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getJob().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Result.Failed.Job }
         * 
         * 
         */
        public List<Result.Failed.Job> getJob() {
            if (job == null) {
                job = new ArrayList<Result.Failed.Job>();
            }
            return this.job;
        }

        /**
         * Gets the value of the count property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getCount() {
            return count;
        }

        /**
         * Sets the value of the count property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setCount(Byte value) {
            this.count = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="group" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="project" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="permalink" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *       &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "id",
            "name",
            "group",
            "project",
            "permalink",
            "error"
        })
        public static class Job {

            @XmlElement(required = true)
            protected String id;
            @XmlElement(required = true)
            protected String name;
            @XmlElement(required = true)
            protected String group;
            @XmlElement(required = true)
            protected String project;
            @XmlElement(required = true)
            protected String permalink;
            @XmlElement(required = true)
            protected String error;
            @XmlAttribute(name = "index")
            protected Byte index;
            @XmlAttribute(name = "href")
            protected String href;

            /**
             * Gets the value of the id property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getId() {
                return id;
            }

            /**
             * Sets the value of the id property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setId(String value) {
                this.id = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the group property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGroup() {
                return group;
            }

            /**
             * Sets the value of the group property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGroup(String value) {
                this.group = value;
            }

            /**
             * Gets the value of the project property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProject() {
                return project;
            }

            /**
             * Sets the value of the project property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProject(String value) {
                this.project = value;
            }

            /**
             * Gets the value of the permalink property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPermalink() {
                return permalink;
            }

            /**
             * Sets the value of the permalink property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPermalink(String value) {
                this.permalink = value;
            }

            /**
             * Gets the value of the error property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getError() {
                return error;
            }

            /**
             * Sets the value of the error property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setError(String value) {
                this.error = value;
            }

            /**
             * Gets the value of the index property.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getIndex() {
                return index;
            }

            /**
             * Sets the value of the index property.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setIndex(Byte value) {
                this.index = value;
            }

            /**
             * Gets the value of the href property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHref() {
                return href;
            }

            /**
             * Sets the value of the href property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHref(String value) {
                this.href = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="job" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="group" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="project" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="permalink" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "job"
    })
    public static class Skipped {

        protected List<Result.Skipped.Job> job;
        @XmlAttribute(name = "count")
        protected Byte count;

        /**
         * Gets the value of the job property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the job property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getJob().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Result.Skipped.Job }
         * 
         * 
         */
        public List<Result.Skipped.Job> getJob() {
            if (job == null) {
                job = new ArrayList<Result.Skipped.Job>();
            }
            return this.job;
        }

        /**
         * Gets the value of the count property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getCount() {
            return count;
        }

        /**
         * Sets the value of the count property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setCount(Byte value) {
            this.count = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="group" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="project" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="permalink" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *       &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "id",
            "name",
            "group",
            "project",
            "permalink"
        })
        public static class Job {

            @XmlElement(required = true)
            protected String id;
            @XmlElement(required = true)
            protected String name;
            @XmlElement(required = true)
            protected String group;
            @XmlElement(required = true)
            protected String project;
            @XmlElement(required = true)
            protected String permalink;
            @XmlAttribute(name = "index")
            protected Byte index;
            @XmlAttribute(name = "href")
            protected String href;

            /**
             * Gets the value of the id property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getId() {
                return id;
            }

            /**
             * Sets the value of the id property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setId(String value) {
                this.id = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the group property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGroup() {
                return group;
            }

            /**
             * Sets the value of the group property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGroup(String value) {
                this.group = value;
            }

            /**
             * Gets the value of the project property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProject() {
                return project;
            }

            /**
             * Sets the value of the project property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProject(String value) {
                this.project = value;
            }

            /**
             * Gets the value of the permalink property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPermalink() {
                return permalink;
            }

            /**
             * Sets the value of the permalink property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPermalink(String value) {
                this.permalink = value;
            }

            /**
             * Gets the value of the index property.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getIndex() {
                return index;
            }

            /**
             * Sets the value of the index property.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setIndex(Byte value) {
                this.index = value;
            }

            /**
             * Gets the value of the href property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHref() {
                return href;
            }

            /**
             * Sets the value of the href property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHref(String value) {
                this.href = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="job" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="group" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="project" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="permalink" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "job"
    })
    public static class Succeeded {

        protected List<Result.Succeeded.Job> job;
        @XmlAttribute(name = "count")
        protected Byte count;

        /**
         * Gets the value of the job property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the job property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getJob().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Result.Succeeded.Job }
         * 
         * 
         */
        public List<Result.Succeeded.Job> getJob() {
            if (job == null) {
                job = new ArrayList<Result.Succeeded.Job>();
            }
            return this.job;
        }

        /**
         * Gets the value of the count property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getCount() {
            return count;
        }

        /**
         * Sets the value of the count property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setCount(Byte value) {
            this.count = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="group" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="project" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="permalink" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *       &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "id",
            "name",
            "group",
            "project",
            "permalink"
        })
        public static class Job {

            @XmlElement(required = true)
            protected String id;
            @XmlElement(required = true)
            protected String name;
            @XmlElement(required = true)
            protected String group;
            @XmlElement(required = true)
            protected String project;
            @XmlElement(required = true)
            protected String permalink;
            @XmlAttribute(name = "index")
            protected Byte index;
            @XmlAttribute(name = "href")
            protected String href;

            /**
             * Gets the value of the id property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getId() {
                return id;
            }

            /**
             * Sets the value of the id property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setId(String value) {
                this.id = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the group property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGroup() {
                return group;
            }

            /**
             * Sets the value of the group property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGroup(String value) {
                this.group = value;
            }

            /**
             * Gets the value of the project property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProject() {
                return project;
            }

            /**
             * Sets the value of the project property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProject(String value) {
                this.project = value;
            }

            /**
             * Gets the value of the permalink property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPermalink() {
                return permalink;
            }

            /**
             * Sets the value of the permalink property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPermalink(String value) {
                this.permalink = value;
            }

            /**
             * Gets the value of the index property.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getIndex() {
                return index;
            }

            /**
             * Sets the value of the index property.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setIndex(Byte value) {
                this.index = value;
            }

            /**
             * Gets the value of the href property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHref() {
                return href;
            }

            /**
             * Sets the value of the href property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHref(String value) {
                this.href = value;
            }

        }

    }

}