package diagram01;

public interface Publisher {
void subscribe(Subscriber subscriber);
void unsubscribe(Subscriber subscriber);
void publish(Readable readable);

}
