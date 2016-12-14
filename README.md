##CommonAdapter
###如何使用

+ 添加依赖

	在根目录下的```build.gradle```中添加：
	
	```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	```
	
	在app的```build.gradle```中添加依赖：
	
	```
	dependencies {
	        compile 'com.github.fccaikai:CommonAdapter:0.2.0'
	}
	```

+ 初始化

	初始化时带入参数
	
	```
	mRecyclerView.setAdapter(new CommonAdapter<String>(initData(),R.layout.item_text){
        @Override
        protected void setupViewHolder(RecyclerViewHolder holder, int position, String item) {
        	//通过getView 取到对应的View
            holder.getView(R.id.xxx);
        }
    });
	```
	
+ 初始化时不带参数

	```
	adapter = new CommonAdapter<String>(R.layout.item_text) {
	
        @Override
        protected void setupViewHolder(RecyclerViewHolder holder, int position, String item) {
        	//TODO
        }
    };
	
    mRecyclerView.setAdapter(adapter);
    adapter.init(initData());
	```

+ 添加点击事件

	```
	//add item click listener
    adapter.addOnItemClickListener(new CommonAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(int position) {

        }
    });
	```

+ 添加长按事件

	```
	//add item long click listener
    adapter.addOnItemLongClickListener(new CommonAdapter.OnItemLongClickListener() {
        @Override
        public void onItemLongClick(int position) {

        }
    });
	```