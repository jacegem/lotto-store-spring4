package lotto.store.controller;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;

@Entity // indicates that this is an Entity
@Cache  // Annotate your entity classes with @Cache to make them cacheable.
        // The cache is shared by all running instances of your application
        // and can both improve the speed and reduce the cost of your application.
        // Memcache requests are free and typically complete in a couple milliseconds.
        // Datastore requests are metered and typically complete in tens of milliseconds.
public class LottoStore {
	@com.googlecode.objectify.annotation.Id 
	public Long id;
}  


