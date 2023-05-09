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
        private Collection collection;

        public Collection getCollection() {
            return collection;
        }

        public void setCollection(Collection collection) {
            this.collection = collection;
        }

        public static class Collection {
            private String id;
            private String handle;
            private String title;
            private String description;
            private Image image;
            private Products products;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getHandle() {
                return handle;
            }

            public void setHandle(String handle) {
                this.handle = handle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public Image getImage() {
                return image;
            }

            public void setImage(Image image) {
                this.image = image;
            }

            public Products getProducts() {
                return products;
            }

            public void setProducts(Products products) {
                this.products = products;
            }
        }

        public static class Image {
            private String id;
            private String url;

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

        public static class Products {
            private List<Edge> edges;

            public List<Edge> getEdges() {
                return edges;
            }

            public void setEdges(List<Edge> edges) {
                this.edges = edges;
            }

            public static class Edge {
                private Node node;

                public Node getNode() {
                    return node;
                }

                public void setNode(Node node) {
                    this.node = node;
                }
            }

            public static class Node {
                private String id;
                private String title;
                private FeaturedImage featuredImage;

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

                public FeaturedImage getFeaturedImage() {
                    return featuredImage;
                }

                public void setFeaturedImage(FeaturedImage featuredImage) {
                    this.featuredImage = featuredImage;
                }
            }

            public static class FeaturedImage {
                private String id;
                private String url;

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
