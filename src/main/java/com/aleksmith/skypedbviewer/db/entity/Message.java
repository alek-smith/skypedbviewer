package com.aleksmith.skypedbviewer.db.entity;

import java.time.Instant;

import lombok.Data;

@Data
public class Message {
    
    private int id;
    private boolean isPermanent;
    private int convoId;
    private String chatName;
    private String author;
    private String fromDisplayName;
    private boolean authorWasLive;
    private byte[] GUID;
    private String dialogPartner;
    private Instant timestamp;
    private Type type;
    private int sendingStatus;
    private int consumptionStatus;
    private String editedBy;
    private int editedTimestamp;
    private int paramKey;
    private int paramValue;
    private String body;
    private String identities;
    private String reason;
    private LeaveReason leaveReason;
    private int participantCount;
    private int errorCode;
    private int chatmsgType;
    private int chatmsgStatus;
    private boolean bodyIsRawXml;
    private int oldOptions;
    private int newOptions;
    private int newRole;
    private int pkId;
    private int crc;
    private int remoteId;
    private String callGUID;
    private String extpropContactReviewDate;
    private Instant extpropContantReceviedStamp;
    private int extpropContactReviewed;
    private int optionBits;
    private int serverId;
    private int annotationVersion;
    private long timestampMs;
    private String language;
    private String botsSettings;
    private String reactionThread;
    private int contentFlags;

    public enum Type {

    }

    public enum LeaveReason {

        UNKNOWN(-1),
        NO_ANSWER(100),
        MANUAL(101),
        BUSY(102),
        CONNECTION_DROPPED(103),
        NO_SKYPEOUT_SUBSCRIPTION(104),
        PSTN_INVALID_NUMBER(109),
        UNSPECIFIED_ERROR(124);

        private int id;

        LeaveReason(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

    }

}