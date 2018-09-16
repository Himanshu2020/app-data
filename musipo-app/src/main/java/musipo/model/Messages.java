package musipo.model;

import musipo.entity.AbstractTimestampEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by G510 on 30-03-2017.
 */


@Entity
@Inheritance
@Table(name = "messages")
public class Messages extends AbstractTimestampEntity{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "message_id", unique = true)
    private String id;

    @Column(name = "chat_room_id")
    private String chatRoomId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "sync_id")
    private String syncId;

    public String getSyncId() {
        return syncId;
    }

    public void setSyncId(String syncId) {
        this.syncId = syncId;
    }

    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "id='" + id + '\'' +
                ", chatRoomId='" + chatRoomId + '\'' +
                ", userId='" + userId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
