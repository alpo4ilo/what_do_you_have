package comalexpolyanskyi.github.foodandhealth.dao.dataObject;

import android.database.Cursor;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import comalexpolyanskyi.github.foodandhealth.dao.database.contract.ArticleDescription;
import comalexpolyanskyi.github.foodandhealth.dao.database.contract.Favorites;

public class ArticleDO implements Serializable {

    @SerializedName("like")
    private int likeCount;

    @SerializedName("repost_count")
    private int repostCount;

    @SerializedName("description")
    private String description;

    @SerializedName("id")
    private int id;

    @SerializedName("uid")
    private int uid;

    @SerializedName("name")
    private String name;

    @SerializedName("photo")
    private String photo;

    @SerializedName("type")
    private int type;

    @SerializedName("user_id")
    private int userId;

    @SerializedName("isLike")
    private int isLike;

    @SerializedName("isRepost")
    private int isRepost;

    public ArticleDO(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndex(ArticleDescription.ID));
        this.name = cursor.getString(cursor.getColumnIndex(ArticleDescription.NAME));
        this.photo = cursor.getString(cursor.getColumnIndex(ArticleDescription.IMAGE_URI));
        this.likeCount = cursor.getInt(cursor.getColumnIndex(ArticleDescription.LIKE_COUNT));
        this.repostCount = cursor.getInt(cursor.getColumnIndex(ArticleDescription.REPOST_COUNT));
        this.description = cursor.getString(cursor.getColumnIndex(ArticleDescription.DESCRIPTION));
        this.userId = cursor.getInt(cursor.getColumnIndex(Favorites.USER_ID));
        this.isLike =  cursor.getInt(cursor.getColumnIndex(Favorites.ISLIKE));
        this.isRepost = cursor.getInt(cursor.getColumnIndex(Favorites.ISFAVORITES));
    }

    public String getDescription() {
        return description;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getFavCount() {
        return repostCount;
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public int getUid() {
        return uid;
    }

    public int getUserId() {
        return userId;
    }

    public boolean isLike() {
        return isLike != 0;
    }

    public boolean isRepost() {
        return isRepost != 0;
    }

    public int getRepost() {
        return isRepost;
    }

    public int getLike() {
        return isLike;
    }

    public String getName() {
        return name;
    }

    public String getPhotoUrl() {
        return photo;
    }
}
