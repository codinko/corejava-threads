package com.codinko.threads.highlevelconcurrency;

public class BQ_LinkedBQ_ArrayBQ {

/**
 * public interface Collection<E> extends Iterable<E> {
 * 
 * public interface Queue<E> extends Collection<E> {
 * 
 * public interface BlockingQueue<E> extends Queue<E> {
 * 
 */
/**
 * BlockingQueue -------------
 * 
 * BlockingQueue extends Queue
 * 
 * A {@link java.util.Queue} that additionally supports operations that wait
 * for the queue to become non-empty when retrieving an element, and wait for
 * space to become available in the queue when storing an element.
 * 
 * BlockingQueue methods come in four forms, with different ways of handling
 * operations that cannot be satisfied immediately, but may be satisfied at
 * some point in the future:
 * 
 * Insert /Remove:
 * 
 * 1. add add(e) / remove() - Throws exception
 * 
 * 2. offer offer(e) / poll() - Special value [ null for poll, false for
 * offer]
 * 
 * 3. put put(e) / take() - blocks the current thread indefinitely until the
 * operation can succeed
 * 
 * 4. offer(Object, long, TimeUnit) offer(e, time, unit)/ poll(long,
 * TimeUnit) poll(time, unit) - blocks for only a given maximum time limit
 * before giving up.
 * 
 * A BlockingQueue does not accept null elements. Implementations throw
 * NullPointerException on attempts to add, put or offer a null. A null is
 * used as a sentinel value to indicate failure of poll operations.
 * 
 * A BlockingQueue may be capacity bounded. At any given time it may have a
 * remainingCapacity beyond which no additional elements can be put without
 * blocking. A BlockingQueue without any intrinsic capacity constraints
 * always reports a remaining capacity of Integer.MAX_VALUE.
 * 
 * BlockingQueue implementations are designed to be used primarily for
 * producer-consumer queues, but additionally support the
 * {@link java.util.Collection} interface. So, for example, it is possible to
 * remove an arbitrary element from a queue using remove(x). However, such
 * operations are in general not performed very efficiently, and are intended
 * for only occasional use, such as when a queued message is cancelled.
 * 
 * BlockingQueue implementations are thread-safe. All queuing methods achieve
 * their effects atomically using internal locks or other forms of
 * concurrency control. However, the bulk Collection operations addAll,
 * containsAll, retainAll and removeAll are not necessarily performed
 * atomically unless specified otherwise in an implementation. So it is
 * possible, for example, for addAll(c) to fail (throwing an exception) after
 * adding only some of the elements in c.
 * 
 * Unlike take(); peek() method returns head of the queue without removing
 * it.
 * 
 */

/**
 * LinkedBlockingQueue -------------------
 * 
 * LinkedBlockingQueue extends AbstractQueue implements BlockingQueue {
 * 
 * An optionally-bounded {@linkplain BlockingQueue blocking queue} based on
 * linked nodes. This queue orders elements FIFO (first-in-first-out).
 * 
 * Linked queues typically have higher throughput than array-based queues but
 * less predictable performance in most concurrent applications.
 * 
 * The optional capacity bound constructor argument serves as a way to
 * prevent excessive queue expansion. The capacity, if unspecified, is equal
 * to {@link Integer#MAX_VALUE}. Linked nodes are dynamically created upon
 * each insertion unless this would bring the queue above capacity.
 * 
 * -> A variant of the "two lock queue" algorithm.
 * 
 * The putLock gates entry to put (and offer). Similarly for the takeLock.
 * 
 * The "count" field that they both rely on is maintained as an atomic to
 * avoid needing to get both locks in most cases.
 */

	/**
	 * ArrayBlockingQueue ------------------
	 * 
	 * ArrayBlockingQueue extends AbstractQueue implements BlockingQueue {
	 * 
	 * A bounded {@linkplain BlockingQueue blocking queue} backed by an array.
	 * This queue orders elements FIFO (first-in-first-out).
	 * 
	 * This is a classic &quot;bounded buffer&quot;, in which a fixed-sized
	 * array holds elements inserted by producers and extracted by consumers.
	 * Once created, the capacity cannot be increased. Attempts to put an
	 * element into a full queue will result in the operation blocking; attempts
	 * to take an element from an empty queue will similarly block.
	 * 
	 * This class supports an optional fairness policy for ordering waiting
	 * producer and consumer threads. By default, this ordering is not
	 * guaranteed. However, a queue constructed with fairness set to true grants
	 * threads access in FIFO order. Fairness generally decreases throughput but
	 * reduces variability and avoids starvation.
	 * 
	 * -> Concurrency control uses the classic two-condition algorithm
	 * 
	 */
}
