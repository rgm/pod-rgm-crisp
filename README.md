# crisp

Freeze and thaw with [Nippy](https://github.com/ptaoussanis/nippy) from a
babashka pod.

## Building

Assuming `native-image` is on your PATH:

```
$ script/compile
```

This produces a GraalVM binary file you can use as a local pod with

```clojure
(pods/load-pod "path/to/crisp")
(require '[pod.crisp :as crisp])
(crisp/freeze {:a 1 :b 2})
```

## Testing

```
$ ./test_pod.bb
```

## Inspiration

😘 and 🙏 to Nate Jones for [brisk](https://github.com/justone/brisk) and
[pod-racer](https://github.com/justone/bb-pod-racer). No way was I gonna figure
out GraalVM builds and building a pod on my own.
