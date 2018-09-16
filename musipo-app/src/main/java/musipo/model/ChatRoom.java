package musipo.model;

import musipo.entity.AbstractTimestampEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by G510 on 30-03-2017.
 */

@Entity
@Inheritance
@DiscriminatorColumn(name = "user_type")
@Table(name = "chat_rooms")
public class ChatRoom extends AbstractTimestampEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "chat_room_id", unique = true)
    private String id;
    private String name;
    @Column(name = "user_id")
    private String userId;

    @Column(name = "chat_room_user")
    private String chatRoomUser;

    @Column(name = "associated_user_id")
    private String associatedUserId;

    public String getAssociatedUserId() {
        return associatedUserId;
    }

    public void setAssociatedUserId(String associatedUserId) {
        this.associatedUserId = associatedUserId;
    }

    public ChatRoom() {
    }

    public ChatRoom(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatRoomUser() {
        return chatRoomUser;
    }

    public void setChatRoomUser(String chatRoomUser) {
        this.chatRoomUser = chatRoomUser;
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", chatRoomUser='" + chatRoomUser + '\'' +
                ", associatedUserId='" + associatedUserId + '\'' +
                '}';
    }
}
