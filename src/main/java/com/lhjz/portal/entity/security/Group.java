package com.lhjz.portal.entity.security;
// default package

// Generated May 6, 2015 11:39:38 AM by Hibernate Tools 4.3.1

import com.lhjz.portal.pojo.Enum.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Group generated by hbm2java
 */
@Entity
@Table(name = "tms_groups")
public class Group implements java.io.Serializable, Comparable<Group> {

    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = 3805010763422813183L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "group_name", nullable = false, length = 50)
    private String groupName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private Set<GroupMember> groupMembers = new HashSet<GroupMember>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private Set<GroupAuthority> groupAuthorities = new HashSet<GroupAuthority>(
            0);

    private String creator;

    private String updater;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.Normal;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group(String groupName, Set<GroupMember> groupMembers,
                 Set<GroupAuthority> groupAuthorities) {
        this.groupName = groupName;
        this.groupMembers = groupMembers;
        this.groupAuthorities = groupAuthorities;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<GroupMember> getGroupMembers() {
        return this.groupMembers;
    }

    public void setGroupMembers(Set<GroupMember> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public Set<GroupAuthority> getGroupAuthorities() {
        return this.groupAuthorities;
    }

    public void setGroupAuthorities(Set<GroupAuthority> groupAuthorities) {
        this.groupAuthorities = groupAuthorities;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Group [id=" + id + ", groupName=" + groupName + ", creator="
                + creator + ", updater=" + updater + ", status=" + status
                + ", createDate=" + createDate + ", updateDate=" + updateDate
                + "]";
    }

    @Override
    public int compareTo(Group o) {
        return getGroupName().compareTo(o.getGroupName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Group group = (Group) o;
        return id.equals(group.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
