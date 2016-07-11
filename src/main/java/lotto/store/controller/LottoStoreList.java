package lotto.store.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LottoStoreList {
	@JsonProperty("pageIsPrev")
    private boolean pageIsPrev;
    @JsonProperty("pageIsNext")
    private boolean pageIsNext;
    
    @JsonProperty("arr")
    public List<LottoStore> storeList;
    
    @JsonProperty("pageStart")
    private int pageStart;
    @JsonProperty("nowPage")
    private int nowPage;
    @JsonProperty("pageEnd")
    public int pageEnd;
    @JsonProperty("totalPage")
    private int totalPage;
    @JsonProperty("sltSido2")
    private int sltSido2;
    
    
}
