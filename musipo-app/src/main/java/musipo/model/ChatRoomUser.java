package musipo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Himanshu Bramhvanshi on 30-08-2017.
 */


@Entity
@Inheritance
@DiscriminatorColumn(name = "user_type")
@Table(name = "chat_rooms_user")
public class ChatRoomUser {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "chat_room_id")
    private String chatRoomId;

    @Column(name = "user_id")
    private String userId;

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

    @Override
    public String toString() {
        return "ChatRoomUser{" +
                "id='" + id + '\'' +
                ", chatRoomId='" + chatRoomId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}


