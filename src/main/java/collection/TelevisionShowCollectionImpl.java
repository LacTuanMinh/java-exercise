package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TelevisionShowCollectionImpl implements TelevisionShowCollection {

  private List<TelevisionShow> list = new ArrayList<>();

  @Override
  public TelevisionShowIterator iterator() {
    return new TelevisionShowIteratorImpl(list);
  }

  @Override
  public void addShow(TelevisionShow show) {
    list.add(show);
  }

  @Override
  public TelevisionShowIterator channelIterator(Channel channel) {
    return new TelevisionShowIteratorImpl(list, channel);
  }


  private class TelevisionShowIteratorImpl implements TelevisionShowIterator {

    private List<TelevisionShow> list;
    private int position = -1;
    private Channel channel;

    TelevisionShowIteratorImpl(List<TelevisionShow> list) {
      this.list = list;
      this.channel = Channel.ALL;
    }

    TelevisionShowIteratorImpl(List<TelevisionShow> list, Channel channel) {
      List<TelevisionShow> temp = new ArrayList<>();

      for (TelevisionShow show : list) {
        if (channel.equals(show.getChannel())) {
          temp.add(show);
        }
      }
      this.list = temp;
      this.channel = channel;
    }

    @Override
    public boolean hasNext() {
      return position + 1 < list.size();
    }

    @Override
    public TelevisionShow next() {
      // TODO
      return position + 1 < list.size() ? list.get(++position) : null;
    }

    @Override
    public boolean hasPrevious() {
      // TODO
      return position - 1 >= -1;
    }

    @Override
    public TelevisionShow previous() {
      // TODO
      return position - 1 >= -1 ? list.get(position--) : null;
    }
  }
}
