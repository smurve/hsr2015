package org.smurve.hsr2014.domain.gents;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEntityMetaData is a Querydsl query type for EntityMetaData
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEntityMetaData extends EntityPathBase<EntityMetaData> {

    private static final long serialVersionUID = 1716140375L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEntityMetaData entityMetaData = new QEntityMetaData("entityMetaData");

    public final QLabelled _super;

    public final SetPath<AttributeMetaData, QAttributeMetaData> attributes = this.<AttributeMetaData, QAttributeMetaData>createSet("attributes", AttributeMetaData.class, QAttributeMetaData.class, PathInits.DIRECT2);

    public final StringPath entityName = createString("entityName");

    //inherited
    public final StringPath id;

    // inherited
    public final QGentsLabel label;

    //inherited
    public final StringPath uniqueName;

    public QEntityMetaData(String variable) {
        this(EntityMetaData.class, forVariable(variable), INITS);
    }

    public QEntityMetaData(Path<? extends EntityMetaData> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEntityMetaData(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEntityMetaData(PathMetadata metadata, PathInits inits) {
        this(EntityMetaData.class, metadata, inits);
    }

    public QEntityMetaData(Class<? extends EntityMetaData> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QLabelled(type, metadata, inits);
        this.id = _super.id;
        this.label = _super.label;
        this.uniqueName = _super.uniqueName;
    }

}

