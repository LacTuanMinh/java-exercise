package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TelevisionShowCollectionImpl implements TelevisionShowCollection {

  private List<TelevisionShow> list = new ArrayList<>();

  @Override
  public TelevisionShowIterator iterator() {
    // TODO
    return new TelevisionShowIteratorImpl();
  }

  @Override
  public void addShow(TelevisionShow show) {
    // TODO
    list.add(show);
  }

  @Override
  public TelevisionShowIterator channelIterator(Channel channel) {
    // TODO
    return new TelevisionShowIteratorImpl(channel);
  }

  private class TelevisionShowIteratorImpl implements TelevisionShowIterator {

    private int position = 0;
    private Channel channel;

    TelevisionShowIteratorImpl() {
      this.channel = Channel.ALL;
    }

    TelevisionShowIteratorImpl(Channel channel) {
      this.channel = channel;
    }

    @Override
    public boolean hasNext() {

      // TODO
      if (this.channel == Channel.ALL) {
        return position < list.size();
      } else {

        int i = position;
        while (i < list.size()) {

          if (list.get(i).getChannel() == this.channel) {
            return true;
          } else {
            i++;
          }
        }
        return false;
      }
    }

    @Override
    public TelevisionShow next() {
      // TODO

      if (channel == Channel.ALL) {
        return position < list.size() ? list.get(position++) : null;
      } else {

        int i = position;
        while (i < list.size()) {
          TelevisionShow tvShow = list.get(i);
          if (tvShow.getChannel() == this.channel) {
            position = ++i;
            return tvShow;
          }
          i++;
        }
      }
      return null;
    }

    @Override
    public boolean hasPrevious() {
      // TODO
      return position - 1 >= 0;
    }

    @Override
    public TelevisionShow previous() {
      // TODO
      return list.get(--position);
    }
  }
}
