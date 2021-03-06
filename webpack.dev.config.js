const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports={
	entry: './src/main/ts/index.tsx',
	output: {
		path: path.resolve(__dirname, '/src/main/resources/static'),
		filename: 'bundle.js',
		publicPath: '/'
	},
	resolve: {
		extensions: ['.js', '.ts', '.tsx']
	},
	module: {
		rules:[{
				test: /\.tsx?$/,
				loader: 'ts-loader'
			}, {
				test: /\.css$/,
				use: ['style-loader', 'css-loader']
			}, {
				test: /\.woff(\?v=\d+\.\d+\.\d+)?$/,
				loader: "url-loader?limit=10000&mimetype=application/font-woff"
			}, {
				test: /\.woff2(\?v=\d+\.\d+\.\d+)?$/,
				loader: "url-loader?limit=10000&mimetype=application/font-woff"
			}, {
				test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/,
				loader: "url-loader?limit=10000&mimetype=application/octet-stream"
			}, {
				test: /\.eot(\?v=\d+\.\d+\.\d+)?$/,
				loader: "file-loader"
			}, {
				test: /\.svg(\?v=\d+\.\d+\.\d+)?$/,
				loader: "url-loader?limit=10000&mimetype=image/svg+xml"
			}, {
				test: /\.(png|jpg|gif)$/,
				loader: "url-loader?limit=8192"
		  }]
	},
	devtool: "source-map",
	devServer:{
		historyApiFallback: true,
		compress: true,
		host: "0.0.0.0",
		port: 3000,
		proxy: {
			"/api/**": "http://localhost:8000"
		}
	},
	plugins: [
		new HtmlWebpackPlugin({
			template: './src/main/resources/templates/main.html'
		})
	]
}