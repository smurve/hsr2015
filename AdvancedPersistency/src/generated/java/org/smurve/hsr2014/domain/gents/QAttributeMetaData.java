package org.smurve.hsr2014.domain.gents;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAttributeMetaData is a Querydsl query type for AttributeMetaData
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAttributeMetaData extends EntityPathBase<AttributeMetaData> {

    private static final long serialVersionUID = 1441870566L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAttributeMetaData attributeMetaData = new QAttributeMetaData("attributeMetaData");

    public final QLabelled _super;

    //inherited
    public final StringPath id;

    // inherited
    public final QGentsLabel label;

    public final NumberPath<Integer> orderByIdx = createNumber("orderByIdx", Integer.class);

    //inherited
    public final StringPath uniqueName;

    public QAttributeMetaData(String variable) {
        this(AttributeMetaData.class, forVariable(variable), INITS);
    }

    public QAttributeMetaData(Path<? extends AttributeMetaData> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAttributeMetaData(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAttributeMetaData(PathMetadata metadata, PathInits inits) {
        this(AttributeMetaData.class, metadata, inits);
    }

    public QAttributeMetaData(Class<? extends AttributeMetaData> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QLabelled(type, metadata, inits);
        this.id = _super.id;
        this.label = _super.label;
        this.uniqueName = _super.uniqueName;
    }

}

