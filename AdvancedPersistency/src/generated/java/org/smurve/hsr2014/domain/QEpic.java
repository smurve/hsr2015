package org.smurve.hsr2014.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEpic is a Querydsl query type for Epic
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEpic extends EntityPathBase<Epic> {

    private static final long serialVersionUID = -1885401589L;

    public static final QEpic epic = new QEpic("epic");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final StringPath uniqueName = _super.uniqueName;

    public QEpic(String variable) {
        super(Epic.class, forVariable(variable));
    }

    public QEpic(Path<? extends Epic> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEpic(PathMetadata metadata) {
        super(Epic.class, metadata);
    }

}

