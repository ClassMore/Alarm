package dev.ioexception.mail.entitiy;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChangeSalePrice is a Querydsl query type for ChangeSalePrice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChangeSalePrice extends EntityPathBase<ChangeSalePrice> {

    private static final long serialVersionUID = -1286755119L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChangeSalePrice changeSalePrice = new QChangeSalePrice("changeSalePrice");

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QLecture lecture;

    public final NumberPath<Integer> newSalePrice = createNumber("newSalePrice", Integer.class);

    public final NumberPath<Integer> oldSalePrice = createNumber("oldSalePrice", Integer.class);

    public QChangeSalePrice(String variable) {
        this(ChangeSalePrice.class, forVariable(variable), INITS);
    }

    public QChangeSalePrice(Path<? extends ChangeSalePrice> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChangeSalePrice(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChangeSalePrice(PathMetadata metadata, PathInits inits) {
        this(ChangeSalePrice.class, metadata, inits);
    }

    public QChangeSalePrice(Class<? extends ChangeSalePrice> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lecture = inits.isInitialized("lecture") ? new QLecture(forProperty("lecture")) : null;
    }

}

