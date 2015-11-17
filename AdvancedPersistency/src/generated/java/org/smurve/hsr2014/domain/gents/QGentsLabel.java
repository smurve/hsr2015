package org.smurve.hsr2014.domain.gents;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGentsLabel is a Querydsl query type for GentsLabel
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGentsLabel extends EntityPathBase<GentsLabel> {

    private static final long serialVersionUID = -1257820694L;

    public static final QGentsLabel gentsLabel = new QGentsLabel("gentsLabel");

    public final org.smurve.hsr2014.domain.QBaseEntity _super = new org.smurve.hsr2014.domain.QBaseEntity(this);

    //inherited
    public final StringPath id = _super.id;

    public final StringPath language = createString("language");

    public final StringPath plural = createString("plural");

    public final StringPath singular = createString("singular");

    //inherited
    public final StringPath uniqueName = _super.uniqueName;

    public QGentsLabel(String variable) {
        super(GentsLabel.class, forVariable(variable));
    }

    public QGentsLabel(Path<? extends GentsLabel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGentsLabel(PathMetadata metadata) {
        super(GentsLabel.class, metadata);
    }

}

