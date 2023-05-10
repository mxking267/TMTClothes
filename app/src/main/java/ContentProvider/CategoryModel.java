package ContentProvider;

import android.graphics.Bitmap;

import java.util.List;

public class CategoryModel {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private Collection collections;

        public Collection getCollection() {
            return collections;
        }

        public void setCollection(Collection collection) {
            this.collections = collections;
        }

        public static class Collection {
            public List<Edges> getEdge() {
                return edges;
            }

            public void setEdge(List<Edges> edge) {
                this.edges = edge;
            }

            List<Edges> edges;

            public static class Edges{
                Node node;

                public Node getNode() {
                    return node;
                }

                public void setNode(Node node) {
                    this.node = node;
                }

                public static class Node{
                    String id;
                    String title;
                    Image image;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public Image getImage() {
                        return image;
                    }

                    public void setImage(Image image) {
                        this.image = image;
                    }

                    public static class Image{
                        String id;
                        String url;


                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }
                }
            }
        }
    }



}
