package musipo.model;

import musipo.entity.AbstractTimestampEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by G510 on 31-03-2017.
 */

@Entity
@Inheritance
@Table(name = "playing_status")
public class PlayingStatus extends AbstractTimestampEntity{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "playing_id", unique = true)
    private String id;

    @Column(name = "status")
    private String status;

    @Column(name = "playing_src",columnDefinition="text" )
    private String playingSrc;

    @Column(name = "playing_type")
    private String playingType;

    @Column(name = "playing_info")
    private String playingInfo;


    @Column(name = "user_id")
    private String userId;

    public String getPlayingType() {
        return playingType;
    }

    public void setPlayingType(String playingType) {
        this.playingType = playingType;
    }

    public String getPlayingInfo() {
        return playingInfo;
    }

    public void setPlayingInfo(String playingInfo) {
        this.playingInfo = playingInfo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlayingSrc() {
        return playingSrc;
    }

    public void setPlayingSrc(String playingSrc) {
        this.playingSrc = playingSrc;
    }

    @Override
    public String toString() {
        return "PlayingStatus{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", playingSrc='" + playingSrc + '\'' +
                ", playingType='" + playingType + '\'' +
                ", playingInfo='" + playingInfo + '\'' +
                '}';
    }
}

