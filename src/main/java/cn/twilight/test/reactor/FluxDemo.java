package cn.twilight.test.reactor;

import org.junit.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

//Reactor中的发布者,Flux和Mono,Flux中流可以包含0个1个或多个元素,Mono中流只能包含0个或1个元素
public class FluxDemo {


    //创建一个流,并直接往流上发布一个值为value的数据
    @Test
    public void testJust(){
        Flux.just("hello","world").subscribe(System.out::println);
    }

    @Test
    public void test01(){
        //map,将元素转换成另一种指定类型的数据
        Flux<Integer> flux = Flux.just("1", "2", "3")
                .map(Integer::valueOf);

        //flatMap,将每一个元素映射到一个新的Flux或Mono上,最后这些新的Mono或Flux会被压成(合成)一个新的Flux
        StepVerifier.create(flux)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .verifyComplete();
    }

}
