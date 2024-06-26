package com.lhjz.portal.entity.security;

// default package
// Generated May 6, 2015 11:39:38 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lhjz.portal.entity.Channel;
import com.lhjz.portal.entity.ChannelGroup;
import com.lhjz.portal.entity.Chat;
import com.lhjz.portal.entity.ChatLabel;
import com.lhjz.portal.entity.Project;
import com.lhjz.portal.entity.Schedule;
import com.lhjz.portal.entity.Translate;
import com.lhjz.portal.pojo.Enum.OnlineStatus;
import com.lhjz.portal.pojo.Enum.Status;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "users")
@Data
@ToString(exclude = { "projects", "authorities", "watcherProjects", "watcherTranslates", "voterChats", "joinChannels",
		"subscribeChannels", "actSchedules", "joinChannelGroups", "voterChatLabels" })
@EqualsAndHashCode(of = { "username" })
public class User implements java.io.Serializable, Comparable<User> {

	/** serialVersionUID long */
	private static final long serialVersionUID = -5501393570981445761L;

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 50)
	private String username;

	@JsonIgnore
	@Column(name = "password", nullable = false, length = 255)
	private String password;

	private String mails;

	private String name;

	private String creator;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status = Status.Normal;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginDate;

	private String loginRemoteAddress;

	private long loginCount = 0;

	private String resetPwdToken;

	@Temporal(TemporalType.TIMESTAMP)
	private Date resetPwdDate;

	private Boolean locked;

	@Version
	private long version;

	@Transient
	private OnlineStatus onlineStatus;

	@Transient
	private Date onlineDate;

	// 座机号
	private String phone;

	// 手机号
	private String mobile;

	// 地理位置
	private String place;

	// 职级
	private String level;

	// 爱好
	private String hobby;

	// 个人介绍
	private String introduce;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "user_project", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "project_id") })
	private Set<Project> projects = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
	private Set<Authority> authorities = new HashSet<>(0);

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "watcher_project", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "project_id") })
	private Set<Project> watcherProjects = new HashSet<>();

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "watcher_translate", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "translate_id") })
	private Set<Translate> watcherTranslates = new HashSet<>();

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "voter_chat", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "chat_id") })
	private Set<Chat> voterChats = new HashSet<>();

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "member_channel", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "channel_id") })
	private Set<Channel> joinChannels = new HashSet<>();

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "subscriber_channel", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "channel_id") })
	private Set<Channel> subscribeChannels = new HashSet<>();

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "actor_schedule", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "schedule_id") })
	private Set<Schedule> actSchedules = new HashSet<>();

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "voter_chat_label", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "chat_label_id") })
	private Set<ChatLabel> voterChatLabels = new HashSet<>();

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "member_channel_group", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "channel_group_id") })
	private Set<ChannelGroup> joinChannelGroups = new HashSet<>();

	public User() {
	}

	public User(String username) {
		this.username = username;
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password, boolean enabled, Set<Authority> authorities) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
	}

	@Override
	public int compareTo(User o) {
		return getUsername().compareTo(o.getUsername());
	}

}
