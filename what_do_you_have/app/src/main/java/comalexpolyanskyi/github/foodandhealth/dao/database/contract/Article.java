package comalexpolyanskyi.github.foodandhealth.dao.database.contract;

import comalexpolyanskyi.github.foodandhealth.dao.database.annotations.Table;
import comalexpolyanskyi.github.foodandhealth.dao.database.annotations.dbInteger;
import comalexpolyanskyi.github.foodandhealth.dao.database.annotations.dbLong;
import comalexpolyanskyi.github.foodandhealth.dao.database.annotations.dbString;

@Table(name = "ARTICLE")
public class Article {

    @dbInteger
    public static final String ID = "id";

    @dbString
    public static final String NAME = "name";

    @dbString
    public static final String IMAGE_URI = "imageUrl";

    @dbInteger
    public static final String TYPE = "type";

    @dbLong
    public static final String RECORDING_TIME = "recordingTime";

    @dbLong
    public static final String AGING_TIME = "agingTime";
}
