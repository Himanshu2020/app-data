package musipo.dao;

import musipo.model.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by G510 on 26-03-2017.
 */

@Repository
@Transactional
public class ChatDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ChatRoom> getChatRooms(String userID) {
        String select = "FROM ChatRoom WHERE  user_id!=:userid";

        Query query = entityManager.createQuery(select);
        query.setParameter("userid", userID);

        //  Query query = entityManager.createQuery("from ChatRoom");
        List<ChatRoom> ChatRoomList = query.getResultList();

        return ChatRoomList;
    }

    public List<Messages> getChatMessages(String userID) {
        String select = "FROM  WHERE  chat_room_id=:userid";

        Query query = entityManager.createQuery(select);
        query.setParameter("userid", userID);
        List<ChatRoom> ChatRoomList = query.getResultList();
        return null;
    }

    public ChatRoom createChatRoom(ChatRoom chatRoom) {

        String select = "FROM ChatRoom WHERE  (user_id=:userid and associated_user_id=:associatedUserId) or (user_id=:associatedUserId and associated_user_id=:userid)";
        Query query = entityManager.createQuery(select);
        query.setParameter("userid", chatRoom.getUserId());
        query.setParameter("associatedUserId", chatRoom.getAssociatedUserId());

        List<ChatRoom> chatRoomList = query.getResultList();

        if (chatRoomList != null) {
            System.out.print("---- ");
            if (chatRoomList.size() > 0) {
                System.out.print("---- already is present ");
                chatRoom = chatRoomList.get(0);
            } else {
                entityManager.persist(chatRoom);

                ChatRoomUser chatRoomUser = new ChatRoomUser();
                chatRoomUser.setUserId(chatRoom.getUserId());
                chatRoomUser.setChatRoomId(chatRoom.getId());

                ChatRoomUser chatRoomUser1 = new ChatRoomUser();
                chatRoomUser1.setUserId(chatRoom.getAssociatedUserId());
                chatRoomUser1.setChatRoomId(chatRoom.getId());

                createChatRoomUser(chatRoomUser);
                createChatRoomUser(chatRoomUser1);

                return chatRoom;
            }
        }
        return chatRoom;
    }

    public ChatRoomUser createChatRoomUser(ChatRoomUser chatRoomUser) {
        entityManager.persist(chatRoomUser);
        return chatRoomUser;
    }
}
