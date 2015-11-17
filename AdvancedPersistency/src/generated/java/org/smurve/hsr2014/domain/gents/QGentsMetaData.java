package org.smurve.hsr2014.domain.gents;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGentsMetaData is a Querydsl query type for GentsMetaData
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGentsMetaData extends EntityPathBase<GentsMetaData> {

    private static final long serialVersionUID = -933210983L;

    public static final QGentsMetaData gentsMetaData = new QGentsMetaData("gentsMetaData");

    public final org.smurve.hsr2014.domain.QBaseEntity _super = new org.smurve.hsr2014.domain.QBaseEntity(this);

    public final SetPath<EntityMetaData, QEntityMetaData> entities = this.<EntityMetaData, QEntityMetaData>createSet("entities", EntityMetaData.class, QEntityMetaData.class, PathInits.DIRECT2);

    //inherited
    public final StringPath id = _super.id;

    //inherited
    public final StringPath uniqueName = _super.uniqueName;

    public QGentsMetaData(String variable) {
        super(GentsMetaData.class, forVariable(variable));
    }

    public QGentsMetaData(Path<? extends GentsMetaData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGentsMetaData(PathMetadata metadata) {
        super(GentsMetaData.class, metadata);
    }

}

