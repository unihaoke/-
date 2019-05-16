package com.hzu.paper.service;

import com.hzu.paper.common.Result;
import com.hzu.paper.entity.CollectionHistory;
import com.hzu.paper.entity.CollectionKey;

public interface CollectionService {
    Result addCollection(CollectionHistory collectionHistory);

    Result delCollection(CollectionKey collectionKey);

    Result findCollection(String userId);


}
