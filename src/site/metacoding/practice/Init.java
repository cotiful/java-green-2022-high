package site.metacoding.practice;

/**
 * 
 * @author yuseunghyeon 생성자 실행순서 1. initObject 2.initSetting
 *         3.initListenr(defaul)
 * 
 */

public interface Init {
	void initObject();

	void initSetting();

	default void initListner() {
	};

}
