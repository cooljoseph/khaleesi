const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports={
	entry: './src/main/ts/index.tsx',
	output: {
		path: path.resolve(__dirname, '/src/main/resources/static'),
		filename: 'bundle.js'
	},
	resolve: {
		extensions: ['.js', '.ts', '.tsx']
	},
	module: {
		rules:[
			{
				test: /\.tsx?$/,
				loader: 'ts-loader'
			},
			{
				test: /\.css$/,
				use: ['style-loader', 'css-loader']
			}
		]
	},
	devtool: "source-map",
	// TODO 나중에 prod, dev 설정할 때 띄어 버리자.
	devServer:{
		historyApiFallback: true,
		compress: true,
		publicPath: '/',
		host: "0.0.0.0",
		port: 3000,
		proxy: {
			"**": "http://localhost:8000"
		}
	},
	plugins: [
		new HtmlWebpackPlugin({
			template: './src/main/resources/templates/main.html'
		})
	]
}