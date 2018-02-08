package com.kakaocorp.commerce.khaleesi.base.entity.schedule;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSchedule is a Querydsl query type for Schedule
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSchedule extends EntityPathBase<Schedule> {

    private static final long serialVersionUID = 982759925L;

    public static final QSchedule schedule = new QSchedule("schedule");

    public final StringPath args1 = createString("args1");

    public final StringPath args1name = createString("args1name");

    public final StringPath args2 = createString("args2");

    public final StringPath args2name = createString("args2name");

    public final StringPath args3 = createString("args3");

    public final StringPath args3name = createString("args3name");

    public final StringPath args4 = createString("args4");

    public final StringPath args4name = createString("args4name");

    public final StringPath args5 = createString("args5");

    public final StringPath args5name = createString("args5name");

    public final StringPath code = createString("code");

    public final StringPath codeConcurrentYn = createString("codeConcurrentYn");

    public final DateTimePath<java.time.LocalDateTime> createdDateTime = createDateTime("createdDateTime", java.time.LocalDateTime.class);

    public final StringPath dayOfMonth = createString("dayOfMonth");

    public final StringPath dayOfWeek = createString("dayOfWeek");

    public final StringPath description = createString("description");

    public final StringPath groupCode = createString("groupCode");

    public final StringPath groupConcurrentYn = createString("groupConcurrentYn");

    public final StringPath hour = createString("hour");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath idConcurrentYn = createString("idConcurrentYn");

    public final DateTimePath<java.time.LocalDateTime> lastModifiedDateTime = createDateTime("lastModifiedDateTime", java.time.LocalDateTime.class);

    public final StringPath minute = createString("minute");

    public final StringPath month = createString("month");

    public final StringPath second = createString("second");

    public final StringPath title = createString("title");

    public final StringPath validflag = createString("validflag");

    public final ListPath<Worker, QWorker> workerList = this.<Worker, QWorker>createList("workerList", Worker.class, QWorker.class, PathInits.DIRECT2);

    public QSchedule(String variable) {
        super(Schedule.class, forVariable(variable));
    }

    public QSchedule(Path<? extends Schedule> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSchedule(PathMetadata metadata) {
        super(Schedule.class, metadata);
    }

}

