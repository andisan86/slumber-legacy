package org.automationtest.slumber.pojo;

/**
 * This class describes POJO for web objects.
 */
public class ObjectsPojo {
    private Objects[] objects;

    public Objects[] getObjects() {
        return objects;
    }

    public void setObjects (Objects[] objects) {
        this.objects = objects;
    }

    public static class Objects {
        private String objectName;
        private String objectType;
        private String objectId;
        private String objectNgModel;
        private String objectNgClick;
        private String objectNgIf;
        private String objectHref;
        private String objectNameAttr;

        public String getObjectName() {
            return objectName;
        }

        public void setObjectName(String objectName) {
            this.objectName = objectName;
        }

        public String getObjectType() {
            return objectType;
        }

        public void setObjectType(String objectType) {
            this.objectType = objectType;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public String getObjectNgModel() {
            return objectNgModel;
        }

        public void setObjectNgModel(String objectNgModel) {
            this.objectNgModel = objectNgModel;
        }

        public String getObjectNgClick() {
            return objectNgClick;
        }

        public void setObjectNgClick(String objectNgClick) {
            this.objectNgClick = objectNgClick;
        }

        public String getObjectNgIf() {
            return objectNgIf;
        }

        public void setObjectNgIf(String objectNgIf) {
            this.objectNgIf = objectNgIf;
        }

        public String getObjectHref() {
            return objectHref;
        }

        public void setObjectHref(String objectHref) {
            this.objectHref = objectHref;
        }

        public String getObjectNameAttr() {
            return objectNameAttr;
        }

        public void setObjectNameAttr(String objectNameAttr) {
            this.objectNameAttr = objectNameAttr;
        }
    }
}
