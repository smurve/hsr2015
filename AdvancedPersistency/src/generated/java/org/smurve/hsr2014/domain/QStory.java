package org.smurve.hsr2014.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStory is a Querydsl query type for Story
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStory extends EntityPathBase<Story> {

    private static final long serialVersionUID = 1695147695L;

    public static final QStory story = new QStory("story");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath assignee = createString("assignee");

    public final StringPath criteria = createString("criteria");

    public final StringPath description = createString("description");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath reporter = createString("reporter");

    public final StringPath status = createString("status");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    //inherited
    public final StringPath uniqueName = _super.uniqueName;

    public QStory(String variable) {
        super(Story.class, forVariable(variable));
    }

    public QStory(Path<? extends Story> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStory(PathMetadata metadata) {
        super(Story.class, metadata);
    }

}

